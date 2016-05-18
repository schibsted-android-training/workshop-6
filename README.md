# Overview
In this workshop we're building a simple app with Clean Architecture.

The implementation is the simplest possible. The idea is to make clear the distinction between layers and their responsibilities. 
It doesn't take into account more complex topics like asynchrony or error handling.

# The app
We're creating an application that tracks the last time you had a siesta.
It has two main features:

- Show the date and time of your last siesta
- Tell you had a new siesta by pressing a button

The specifications are better explained in the slides.

# Extras
We propose a few extra tasks to dig deeper into designing with clean architecture in mind:

- New feature that counts the hours since your last siesta
- Make the code asynchronous with callbacks
- Add data mappers between layers
- Use [Optionals](https://github.com/Sloy/gallego) instead of returning nulls
- Wrap the siesta date with a custom entity

# Slides
The slides to follow the workshop can be found [here](https://github.com/schibsted-android-training/workshop-6/blob/start/slides/workshop6.pdf)
