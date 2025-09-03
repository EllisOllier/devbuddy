mod commands;

use std::env;

fn main() {
    let args: Vec<String> = env::args().collect();

    if args.len() < 2 {
        eprintln!("Usage: devbuddy <command>");
        return;
    }

    match args[1].as_str() {
        "init" => commands::init::run(),
        _ => eprintln!("Unknown command: {}", args[1]),
    }
}
