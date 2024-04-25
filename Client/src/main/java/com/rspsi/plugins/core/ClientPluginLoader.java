package com.rspsi.plugins.core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Consumer;

import com.google.common.collect.Lists;

import com.sun.source.util.Plugin;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import plugin.OSRSPlugin;

@Slf4j
public class ClientPluginLoader {

	private static final List<ClientPlugin> plugins = Lists.newArrayList(
            new OSRSPlugin()
            );

	public static void loadPlugins() {
        forEach(ClientPlugin::initializePlugin);
	}

	public static void forEach(Consumer<ClientPlugin> consumer) {
		for(ClientPlugin plugin : plugins) {
			consumer.accept(plugin);
		}
	}
}
