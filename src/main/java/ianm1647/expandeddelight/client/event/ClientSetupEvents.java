package ianm1647.expandeddelight.client.event;

import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class ClientSetupEvents {
    public ClientSetupEvents() {
    }

    public static void onRegisterRenderers() {
        BlockEntityRenderers.register(EDBlockEntityTypes.CINNAMON_SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(EDBlockEntityTypes.CINNAMON_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
