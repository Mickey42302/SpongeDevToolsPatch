package com.mickey42302.devtools.mixin;

import net.minecraft.server.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({Bootstrap.class})
public abstract class BootstrapMixin {
    /**
     * @author Mickey42302
     * @reason Fix issues with command registrar.
     */
    @Overwrite(remap = false)
    public static void validate() {

    }

}