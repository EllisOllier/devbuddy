use std::io::{self, Write};
use std::fs;
use std::path::Path;

pub fn run() {
    let mut project_type = String::new();
    let mut project_name = String::new();

    print!("Enter project type: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut project_type).unwrap();

    print!("Enter project name: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut project_name).unwrap();

    let project_type = project_type.trim();
    let project_name = project_name.trim();

    // Check for existing folder
    if Path::new(project_name).exists() {
        eprintln!("Error: Folder '{}' already exists!", project_name);
        return;
    }

    // Create folder for the project
    match fs::create_dir(project_name){
        Ok(_) => println!("Project folder '{}' created successfully", project_name),
        Err(e) => eprintln!("Failed to create project folder: {}", e),
    }

    println!("Type: {}", project_type);
}
