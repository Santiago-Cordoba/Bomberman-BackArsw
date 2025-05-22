package bomberman.arsw.Model;

public class LifeUpPowerUp extends PowerUp {
    public LifeUpPowerUp(int x, int y) {
        super(PowerUpType.EXTRA_LIFE, x, y);
    }

    @Override
    public void applyEffect(Player player) {
        player.increaseLives(1); // Añade una vida extra al jugador
    }

    @Override
    public String toJsonString() {
        return String.format(
                "{\"type\":\"%s\",\"x\":%d,\"y\":%d}",
                getType().name(),
                getX(),
                getY()
                );
}
}