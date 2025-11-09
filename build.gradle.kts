import org.spongepowered.gradle.plugin.config.PluginLoaders
import org.spongepowered.plugin.metadata.model.PluginDependency

plugins {
    `java-library`
    id("org.spongepowered.gradle.plugin") version "2.1.1"
    id("org.spongepowered.gradle.vanilla") version "0.2.1-SNAPSHOT"
}

group = "com.mickey42302.devtools"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven/") {
        name = "spongepowered-repo"
    }
}

sponge {
    apiVersion("14.0.0")
    license("All-Rights-Reserved")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("mickey42302_devtools") {
        displayName("Dev Tools Patch")
        entrypoint("com.mickey42302.devtools.DevToolsInit")
        description("This plugin unlocks the built-in development tools and provides other patches.")
        links {
            // homepage("https://spongepowered.org")
            // source("https://spongepowered.org/source")
            // issues("https://spongepowered.org/issues")
        }
        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
    }
}

dependencies {
    implementation("org.spongepowered:spongeapi:14.0.0")
    compileOnly("org.spongepowered:mixin:0.8.5")
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
}

minecraft {
    version("1.21.4")
}

val javaTarget = 21
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(javaTarget))
}

tasks.withType(JavaCompile::class).configureEach {
    options.apply {
        encoding = "utf-8"
        if (JavaVersion.current().isJava10Compatible) {
            release.set(javaTarget)
        }
    }
}

tasks.withType(AbstractArchiveTask::class).configureEach {
    isReproducibleFileOrder = true
    isPreserveFileTimestamps = false
}

tasks.withType<Jar>  {
    manifest {
        attributes["MixinConfigs"] = "mixins.mickey42302_devtools.json"
    }
}