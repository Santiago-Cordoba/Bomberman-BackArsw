package bomberman.arsw.Model;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

public class Player implements Serializable {
    // Añade esta constante para controlar la versión de serialización
    private static final long serialVersionUID = 1L;

    private String id;
    private int x;
    private int y;
    private int lives;
    private String name;
    private int bombs;
    private boolean ready;
    private boolean host;
    private int speed;
    private int bombCapacity = 1;
    private int bombRange = 1;
    private boolean invincible = false;

    // Constructor sin argumentos requerido para la deserialización
    public Player() {
        this.id = UUID.randomUUID().toString();
    }

    public Player(int x, int y, int lives, String name, int bombs) {
        this(); // Llama al constructor sin argumentos para inicializar el ID
        this.x = x;
        this.y = y;
        this.lives = lives;
        this.name = name;
        this.bombs = bombs;
        this.ready = false;
        this.host = false;
        this.speed = 1;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    public int getBombRange() {
        return bombRange;
    }

    public void increaseBombRange(int i) {
        bombRange++;
    }

    public Map<String, Object> toMap() {
        return Map.of(
                "id", id,
                "name", name,
                "x", x,
                "y", y,
                "lives", lives,
                "bombCapacity", bombCapacity,
                "bombRange", bombRange,
                "ready", ready,
                "isHost", host
        );
    }

    public void setHost(boolean host) {
        this.host = host;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isHost() {
        return host;
    }

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLives() {
        return lives;
    }

    public String getName() {
        return name;
    }

    public int getBombs() {
        return bombs;
    }

    public boolean isReady() {
        return ready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void increaseLives(int amount) {
        this.lives += amount;
    }

    public String toJsonString() {
        return String.format(
                "{\"id\":\"%s\",\"name\":\"%s\",\"x\":%d,\"y\":%d,\"lives\":%d,\"bombCapacity\":%d,\"isHost\":%b,\"isReady\":%b,\"isInvincible\":%b}",
                id,
                name,
                x,
                y,
                lives,
                bombCapacity,
                bombRange,
                host,
                ready,
                invincible
        );
    }

    public boolean canPlaceBomb() {
        return bombCapacity > 0;
    }

    public void decreaseBombCapacity() {
        if (bombCapacity > 0) {
            bombCapacity--;
        }
    }

    public void increaseBombCapacity() {
        bombCapacity++;
    }

    public int getBombCapacity() {
        return bombCapacity;
}

}
