package com.mickey42302.devtools;

import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.ConstructPluginEvent;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;

@Plugin("mickey42302_devtools")
public class DevToolsInit {
    private final PluginContainer container;
    private final Logger logger;

    @Inject
    DevToolsInit(final PluginContainer container, final Logger logger) {
        this.container = container;
        this.logger = logger;
    }

    @Listener
    public void onConstructPlugin(final ConstructPluginEvent event) {
        this.logger.info("Enabling the development tools...");
    }

}
