package me.padej_.extrasodiumfogfix.mixin;

import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.fog.FogData;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = FogRenderer.class, priority = 1400)
public abstract class FogRendererPatchMixin {

    @Inject(
            method = "applyFog(Lnet/minecraft/client/render/Camera;IZLnet/minecraft/client/render/RenderTickCounter;FLnet/minecraft/client/world/ClientWorld;)Lorg/joml/Vector4f;",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/render/fog/FogData;renderDistanceEnd:F",
                    ordinal = 0,
                    shift = At.Shift.AFTER
            ),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void applyVanillaFog(Camera camera, int viewDistance, boolean thick, RenderTickCounter tickCounter, float skyDarkness, ClientWorld world, CallbackInfoReturnable<Vector4f> cir, float f, Vector4f vector4f, float g, CameraSubmersionType cameraSubmersionType, Entity entity, FogData fogData, float h) {
        if (cameraSubmersionType == CameraSubmersionType.WATER) {
            fogData.environmentalStart = -8.0F;
            fogData.environmentalEnd = 96.0F;
            if (entity instanceof ClientPlayerEntity clientPlayerEntity) {
                fogData.environmentalEnd *= Math.max(0.25F, clientPlayerEntity.getUnderwaterVisibility());
                RegistryEntry<Biome> biome = world.getBiome(camera.getBlockPos());
                if (biome.isIn(BiomeTags.HAS_CLOSER_WATER_FOG)) {
                    fogData.environmentalEnd *= 0.85F;
                }
            }
            fogData.renderDistanceStart = fogData.environmentalStart;
            fogData.renderDistanceEnd = fogData.environmentalEnd;
            fogData.skyEnd = fogData.environmentalEnd;
            fogData.cloudEnd = fogData.environmentalEnd;

        } else if (cameraSubmersionType == CameraSubmersionType.LAVA) {
            if (entity.isSpectator()) {
                fogData.environmentalStart = -8.0F;
                fogData.environmentalEnd = (float) viewDistance * 0.5F;
            } else if (entity instanceof LivingEntity livingEntity && livingEntity.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
                fogData.environmentalStart = 0.0F;
                fogData.environmentalEnd = 5.0F;
            } else {
                fogData.environmentalStart = 0.25F;
                fogData.environmentalEnd = 1.0F;
            }
            fogData.renderDistanceStart = fogData.environmentalStart;
            fogData.renderDistanceEnd = fogData.environmentalEnd;
            fogData.skyEnd = fogData.environmentalEnd;
            fogData.cloudEnd = fogData.environmentalEnd;

        } else if (cameraSubmersionType == CameraSubmersionType.POWDER_SNOW) {
            if (entity.isSpectator()) {
                fogData.environmentalStart = -8.0F;
                fogData.environmentalEnd = (float) viewDistance * 0.5F;
            } else {
                fogData.environmentalStart = 0.0F;
                fogData.environmentalEnd = 2.0F;
            }
            fogData.renderDistanceStart = fogData.environmentalStart;
            fogData.renderDistanceEnd = fogData.environmentalEnd;
            fogData.skyEnd = fogData.environmentalEnd;
            fogData.cloudEnd = fogData.environmentalEnd;
        }
    }
}
