package me.padej_.extrasodiumfogfix.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.fog.DarknessEffectFogModifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = DarknessEffectFogModifier.class, priority = 1400)
public class RestoreDarknessEffectFixin {

    /**
     * @name Tweakemore
     * @id tweakermore
     * @class me.fallenbreath.tweakermore.mixins.tweaks.mc_tweaks.disableDarknessEffect.BackgroundRendererStatusEffectFogModifierMixin
     */
    @Redirect(
            method = "applyDarknessModifier",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;getStatusEffect(Lnet/minecraft/registry/entry/RegistryEntry;)Lnet/minecraft/entity/effect/StatusEffectInstance;"
            )
    )
    private StatusEffectInstance restoreDarknessEffect(LivingEntity entity, RegistryEntry<StatusEffect> effect) {
        return entity.getStatusEffect(StatusEffects.DARKNESS);
    }
}
