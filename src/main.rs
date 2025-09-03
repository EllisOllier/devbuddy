use clap::Parser;

/// Simple program to greet someone
#[derive(Parser)]
struct Args {
    /// Name of the person to greet
    name: String,
}

fn main() {
    let args = Args::parse();
    println!("Hello, {}!", args.name);
}
