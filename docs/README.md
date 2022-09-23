# User Guide
Adapted from https://github.com/fantablack/ip/blob/master/docs/README.md with slight modification
# Duke
> "The important thing to remember, is not to forget"

Duke frees your mind of having to remember things you need to do. It's,

* text-based
* easy to learn
* ~~FAST~~ SUPER FAST to use

All you need to do is,
1. download it from [here](https://github.com/fantablack/ip/releases/tag/A-Jar)
2. double-click it
3. add your tasks
4. let it manage your tasks for you 😜

And best of all, it is ***100% FREE!***

Features:
- [x] Managing tasks
- [x] Managing deadlines
- [x] Managing Events

## Features 

### Todos

Add all the tasks you need to complete! 

### Event

Include all the events you need to attend! 

### Deadlines

Be on top of your deadlines! 

## Usage

### 1. Add a Todo task
Adds a new todo `<task todo>`

Syntax:

`todo <task todo>`

Example of usage:

`todo play games`

Expected outcome:

Adds a new Todo task `play games`.

### 2. Add an Event Task
Adds a new event `<event-name>` at `dd/MM/yyyy HHmm`

Syntax:

`event <event-name> /at dd/MM/yyyy HHmm` 

Please adhere to the date and time format exactly. 

Example of usage:

`event party /at 10/11/2023 1830`

Expected outcome:

Event `party` at `10/11/2023 1830` gets added.

### 3. Add a Deadline task
Adds a Deadline `<deadline-name>` to be done by `dd/MM/yyyy HHmm`

Syntax:

`deadline <task with deadline> /by dd/MM/yyyy HHmm`

Example of usage:

`deadline submit thesis /by 15/3/2022 2359`

Expected outcome:

Adds a new Deadline `submit thesis` to be handed in by `15/3/2022 2359`

### 4. List all Tasks
Syntax:

`list`

Expected Outcome:

Lists all tasks saved in file.

### 5. Find
Find task(s) that contains `<search term>`

Example of usage:

`find <search term>`

Expected outcome:

List of task(s) containing `search term`. 

### 6. Delete <task index>
Deletes a task at a specified `<index>`

Syntax:

`delete <index>`

Example of usage:

`delete 2`

Expected outcome:

Deletes the task at index `2` from the list. 

### 7. Mark
Mark a task at `<index>` as done

Syntax:

`mark <index>`

Example of usage:

`mark 1`

Expected outcome:
Tasks at index `1` is marked done.

### 8. Unmark
Mark a task at `<index>` as not done

Syntax:

`unmark <index>`

Example of usage:

`unmark 1`

Expected outcome:
Tasks at index `1` is marked as not done.

## 9.Exit
Exit the Duke chatbot with a `bye` command

Syntax:
`bye`

