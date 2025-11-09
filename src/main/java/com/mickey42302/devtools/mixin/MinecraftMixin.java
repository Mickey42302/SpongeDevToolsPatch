package com.mickey42302.devtools.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({Minecraft.class})
public abstract class MinecraftMixin {
    /**
     * @author Mickey42302
     * @reason Fix issues with command registrar.
     */
    @Overwrite(remap = false)
    private void selfTest() {

    }
}