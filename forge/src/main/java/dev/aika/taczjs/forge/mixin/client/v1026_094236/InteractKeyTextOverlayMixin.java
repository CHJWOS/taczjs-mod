package dev.aika.taczjs.forge.mixin.client.v1026_094236;

import com.tacz.guns.client.gui.overlay.InteractKeyTextOverlay;
import dev.aika.taczjs.forge.TaCZJSUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = InteractKeyTextOverlay.class, remap = false)
public abstract class InteractKeyTextOverlayMixin {
    @Inject(method = "renderText", at = @At("HEAD"), cancellable = true)
    private static void renderText(GuiGraphics graphics, int width, int height, Font font, String keyName, Component subtitle, CallbackInfo ci) {
        TaCZJSUtils.getClientGun(Minecraft.getInstance().player).ifPresent(gun -> {
            if (gun.isVanillaInteract()) ci.cancel();
        });
    }
}