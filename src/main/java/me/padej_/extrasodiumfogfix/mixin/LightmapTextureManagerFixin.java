package me.padej_.extrasodiumfogfix.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = LightmapTextureManager.class, priority = 1400)
public class LightmapTextureManagerFixin {

    /**
     * @name Tweakemore
     * @id tweakermore
     * @class me.fallenbreath.tweakermore.mixins.tweaks.mc_tweaks.disableDarknessEffect.LightmapTextureManagerMixin
     */
    @Redirect(
            method = "update",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/network/ClientPlayerEntity;getEffectFadeFactor(Lnet/minecraft/registry/entry/RegistryEntry;F)F"
            )
    )
    private float redirectGetEffectFadeFactor(ClientPlayerEntity player, RegistryEntry<StatusEffect> effect, float tickDelta) {
        return player.getEffectFadeFactor(effect, tickDelta);
    }
}


