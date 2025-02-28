package com.buildingblocks.challenges.domain.board;

import com.buildingblocks.challenges.domain.board.entities.Card;
import com.buildingblocks.challenges.domain.board.entities.Turn;
import com.buildingblocks.challenges.domain.board.events.AssignedPlayerToBoard;
import com.buildingblocks.challenges.domain.board.events.CreatedBoard;
import com.buildingblocks.challenges.domain.board.events.StartedBoard;
import com.buildingblocks.challenges.domain.board.values.BoardId;
import com.buildingblocks.challenges.domain.board.values.IsActive;
import com.buildingblocks.challenges.domain.board.values.Title;
import com.buildingblocks.challenges.domain.board.values.Type;
import com.buildingblocks.challenges.domain.player.Player;
import com.buildingblocks.shared.domain.generic.AggregateRoot;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.*;

public class Board extends AggregateRoot<BoardId> {

    private Title title;
    private List<Player> players;
    private Deque<Card> deck;
    private Deque<Card> discardPile;
    private List<Turn> turns;
    private IsActive isActive;

    // region Constructors

    public Board() {
        super(new BoardId());
        this.players = new ArrayList<>();
        this.deck = new ArrayDeque<>();
        this.discardPile = new ArrayDeque<>();
        this.turns = new ArrayList<>();
        this.isActive = IsActive.of(false);
        initializeHandler();
    }

    private Board(BoardId identity) {
        super(identity);
        this.players = new ArrayList<>();
        this.deck = new ArrayDeque<>();
        this.discardPile = new ArrayDeque<>();
        this.turns = new ArrayList<>();
        this.isActive = IsActive.of(false);
        initializeHandler();
    }


    // endregion

   // region Getters and Setters

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Deque<Card> getDeck() {
        return deck;
    }

    public void setDeck(Deque<Card> deck) {
        this.deck = deck;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public Deque<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(Deque<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }


    // endregion

    // region Domain Events

    public void createBoard(String boardName){
        apply(new CreatedBoard(boardName));
    }

    public void assignPlayerToBoard(Player player){
        apply(new AssignedPlayerToBoard(player));
    }

    public void startBoard(String boardId){
        apply(new StartedBoard(boardId));
    }

    // endregion

    // region Public methods

    public void start() {
        isActive = IsActive.of(true);
    }


    public void addPlayer(Player player) {
        if (players.size() > 2){
            throw new IllegalArgumentException("The board is full");
        }

        players.add(player);
    }

    // endregion

    // region Private methods

    private void initializeHandler() {
        subscribe(new BoardHandler(this));
    }

    public void generateDeck() {

        if(deck == null) {
            deck = new ArrayDeque<>();
        }

        deck.clear();

        String[] types = {"Action", "Event", "Object", "Wild"};

        String[] actionTitles = {
                "Robar 2 cartas", "Saltar el turno", "Intercambiar manos",
                "Forzar a otro jugador a robar una carta", "Gritar '¡Muffin!'"
        };
        String[] eventTitles = {
                "¡Muffin! Todos pierden el turno", "Caos total: Barajar todas las cartas",
                "Terremoto: Todos descartan una carta", "Fiesta: Todos roban una carta"
        };
        String[] objectTitles = {
                "Cuchara de madera", "Sombrero de papel", "Calcetín mágico"
        };
        String[] wildTitles = {
                "Elige un jugador para robar una carta", "Inventa una regla nueva"
        };

        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            String type = types[random.nextInt(types.length)];

            String title;
            switch (type) {
                case "Action":
                    title = actionTitles[random.nextInt(actionTitles.length)];
                    break;
                case "Event":
                    title = eventTitles[random.nextInt(eventTitles.length)];
                    break;
                case "Object":
                    title = objectTitles[random.nextInt(objectTitles.length)];
                    break;
                case "Wild":
                    title = wildTitles[random.nextInt(wildTitles.length)];
                    break;
                default:
                    title = "Carta misteriosa";
                    break;
            }

            Card card = new Card(Title.of(title), Type.of(type));
            deck.addLast(card);
        }

        List<Card> tempDeck = new ArrayList<>(deck);
        Collections.shuffle(tempDeck);
        deck.clear();
        deck.addAll(tempDeck);
    }

    // endregion


    public static Board from(final String identity, final List<DomainEvent> events) {
        Board board = new Board(BoardId.of(identity));
        events.forEach(board::apply);
        board.markEventsAsCommitted();
        return board;
    }

}
