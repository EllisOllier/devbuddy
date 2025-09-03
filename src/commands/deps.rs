use std::process::Command;

pub fn check_node() -> bool {
    let output = Command::new("node").arg("--version").output();
    match output {
        Ok(o) if o.status.success() => true,
        _ => false,
    }
}

pub fn check_npm() -> bool {
    let output = Command::new("npm").arg("--version").output();
    match output {
        Ok(o) if o.status.success() => true,
        _ => false,
    }
}

pub fn check_python() -> bool {
    let output = Command::new("python3").arg("--version").output();
    match output {
        Ok(o) if o.status.success() => true,
        _ => false,
    }
}

// Add more checks as needed (e.g., dotnet)
