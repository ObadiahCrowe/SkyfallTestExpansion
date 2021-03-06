package io.obadiah.test.loader;

import io.skyfallsdk.SkyfallServer;
import io.skyfallsdk.world.Dimension;
import io.skyfallsdk.world.World;
import io.skyfallsdk.world.generate.WorldGenerator;
import io.skyfallsdk.world.loader.AbstractWorldLoader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class DatabaseWorldLoader extends AbstractWorldLoader {

    public DatabaseWorldLoader(SkyfallServer server, Path baseDir) {
        super(server, baseDir);
    }

    @Override
    public void unloadAll() {

    }

    @Override
    public CompletableFuture<Optional<World>> load(Path path) throws IOException {
        return null;
    }

    @Override
    public CompletableFuture<Void> unload(String name) {
        return null;
    }

    @Override
    public CompletableFuture<Void> unload(World world) {
        return null;
    }

    @Override
    public CompletableFuture<Optional<World>> get(String name) {
        return null;
    }

    @Override
    public CompletableFuture<World> create(String name, Dimension dimension, WorldGenerator generator) throws IOException {
        return null;
    }

    @Override
    public Collection<World> getLoadedWorlds() {
        return null;
    }
}
