package com.murder.commands;

public class CommandRunnerFactory {

    public static CommandRunner create(CommandData data) throws ClassNotFoundException {

        String command = data.label.toLowerCase();

        switch (command) {
            case "setvillager":
                return new SpawnNPC(data);
            default:
                throw new ClassNotFoundException();
        }
    }
}
