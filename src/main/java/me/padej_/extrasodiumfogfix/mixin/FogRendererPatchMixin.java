package me.padej_.extrasodiumfogfix.mixin;

import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.fog.FogData;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = FogRenderer.class, priority = 1400)
public abstract class FogRendererPatchMixin {

    @Inject(
            method = {"applyFog(Lnet/minecraft/client/render/Camera;IZLnet/minecraft/client/render/RenderTickCounter;FLnet/minecraft/client/world/ClientWorld;)Lorg/joml/Vector4f;"},
            at = {@At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/render/fog/FogData;renderDistanceEnd:F",
                    ordinal = 0,
                    shift = At.Shift.AFTER
            )},
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void undoSodiumExtraFog(Camera camera, int viewDistance, boolean thick, RenderTickCounter tickCounter, float skyDarkness, ClientWorld world, CallbackInfoReturnable<Vector4f> cir, float f, Vector4f vector4f, float g, CameraSubmersionType cameraSubmersionType, Entity entity, FogData fogData, float h) {

        if (cameraSubmersionType == CameraSubmersionType.WATER
                || cameraSubmersionType == CameraSubmersionType.LAVA
                || cameraSubmersionType == CameraSubmersionType.POWDER_SNOW) {
            float near = 0.0F;

            fogData.environmentalStart = near;
            fogData.environmentalEnd = (float) viewDistance * 0.25F;
            fogData.renderDistanceStart = near;
            fogData.renderDistanceEnd = (float) viewDistance * 0.5F;
            fogData.skyEnd = (float) viewDistance * 0.75F;
            fogData.cloudEnd = (float) viewDistance;
        }
    }
}
