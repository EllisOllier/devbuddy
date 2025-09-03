use std::io::{self, Write}; // Used for basic input output (e.g. reading user input)
use std::fs; // Filesystem for creating directories
use std::path::Path; // For working with filesystem paths

use super::deps;

pub fn run() { // Public function
    // Empty, mutable strings to store user input
    let mut project_type = String::new();
    let mut project_name = String::new();

    print!("Enter project type: "); // Displays print without a new line
    io::stdout().flush().unwrap(); // Forces the previous print to appear before waiting for input
    io::stdin().read_line(&mut project_type).unwrap(); // Reads the line and stores it in project_type

    print!("Enter project name: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut project_name).unwrap();

    let project_type = project_type.trim(); // Trim to make sure there are no whitespaces
    let project_name = project_name.trim();

    // Check for dependencies
    let deps_ok = match project_type {
        "react" => {
            if !deps::check_node() || !deps::check_npm() {
                eprintln!("Error: Node.js and npm are required for React projects.");
                false
            } else { true }
        }
        "python" => {
            if !deps::check_python() {
                eprintln!("Error: Python is required for Python projects.");
                false
            } else { true }
        }
        _ => { // Prompt the user if they enter an unsupported dependency type
            eprintln!("Error: Unsupported project type '{}'.", project_type);
            false
        }
    };

    if !deps_ok { // Prompt the user if there are missing dependencies
        eprintln!("Project creation canceled due to missing dependencies.");
        return;
    };

    // Check for existing folder
    if Path::new(project_name).exists() {
        eprintln!("Error: Folder '{}' already exists!", project_name);
        return;
    }

    // Create folder for the project
    match fs::create_dir(project_name){ // Tries to create new directory
        Ok(_) => println!("Project folder '{}' created successfully", project_name), // Ok status with confirmation
        Err(e) => eprintln!("Failed to create project folder: {}", e), // Error status with error message
    }

    println!("Type: {}", project_type);
}
