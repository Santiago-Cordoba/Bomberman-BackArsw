package bomberman.arsw.Model;

public class PowerupCollectRequest {
    private String playerId;
    private int x;
    private int y;

    // Getters y Setters
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y=y;
}
}