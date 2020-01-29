package minegame159.meteorclient.modules.movement;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import minegame159.meteorclient.events.TickEvent;
import minegame159.meteorclient.modules.Category;
import minegame159.meteorclient.modules.Module;
import net.minecraft.server.network.packet.PlayerMoveC2SPacket;

public class NoFall extends Module {
    public NoFall() {
        super(Category.Movement, "no-fall", "Protects you from fall damage.");
    }

    @EventHandler
    private Listener<TickEvent> onTick = new Listener<>(event -> {
        if (mc.player.fallDistance > 2f && !mc.player.isFallFlying()) {
            mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket(true));
        }
    });
}