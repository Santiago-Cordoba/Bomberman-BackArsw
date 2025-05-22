

        package bomberman.arsw.Model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InvincibilityPowerUp extends PowerUp {
    public InvincibilityPowerUp(int x, int y) {
        super(PowerUpType.INVINCIBILITY, x, y);
    }

    @Override
    public void applyEffect(Player player) {
        player.setInvincible(true); // Necesitarás añadir este método a la clase Player

        // Programar el fin de la invencibilidad después de 10 segundos
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> {
            player.setInvincible(false);
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
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