package me.padej_.extrasodiumfogfix.mixin;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = WorldRenderer.class, priority = 1400)
public class WorldRendererFixin {

    /**
     * @name Tweakemore
     * @id tweakermore
     * @class me.fallenbreath.tweakermore.mixins.tweaks.mc_tweaks.disableDarknessEffect.WorldRendererMixin
     */
    @Redirect(
            method = "hasBlindnessOrDarkness",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;hasStatusEffect(Lnet/minecraft/registry/entry/RegistryEntry;)Z")
    )
    private boolean hasBlindnessOrDarkness(LivingEntity instance, RegistryEntry<StatusEffect> effect) {

        return false;
    }
}
