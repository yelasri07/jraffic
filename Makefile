# Makefile for Jraffic

# Variables
MVN = mvn
JAVAFX_RUN = javafx:run
CLEAN = clean
COMPILE = compile

# Default target
all: build run

# Build the project
build:
	$(MVN) $(COMPILE)

# Run the application
run:
	$(MVN) $(JAVAFX_RUN)

# Clean the project
clean:
	$(MVN) $(CLEAN)

# Help
help:
	@echo "Available commands:"
	@echo "  make build   - Compile the project"
	@echo "  make run     - Run the application"
	@echo "  make clean   - Clean the project"
	@echo "  make help    - Show this help message"

.PHONY: all build run clean help