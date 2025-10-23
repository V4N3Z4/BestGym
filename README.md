# Best Gym Ever – Gym Access System

This program helps Best Gym Ever check if a visitor is a current member, a former client, or not authorized.

## What it does

- Reads member data from a file.
- Lets you enter a name or social security number.
- Shows whether the visitor is:
  - A current member (paid within the last year)
  - A former client (membership expired)
  - Not authorized (not found in the file)
- Logs visits of current members to a separate file.

## Files used

- `member.txt`: contains the list of members.
- `visits.txt`: stores visit logs.

## How to use

1. Run the program.
2. Enter the visitor’s name or social security number.
3. The system will show their status and log the visit if they are a current member.

## Requirements

- Java 
