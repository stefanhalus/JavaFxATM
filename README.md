# JavaFxATM
## Java FX ATM simulator
This is a simple application that simulates an ATM (automated transaction machine)
Sorry but the initial screen is in romanian. 

Startup
* run the app
* click on big image with hand and card
* select the language as usual on an atm.

Application implements a new and fany timer
```Java
PauseTransition chitanta = new PauseTransition(Duration.seconds(2));
      chitanta.setOnFinished(event -> ridicatiChitanta());
      chitanta.play();```
```

## Version 3.0 released
### New features
* Database driven accounts and journals, with 3 tables:
** cards
** operations journal
** pin validation journal
* New screen with last 10 operations made on the atm

### Updates and fixes
* Collor forced to green on the last three screens for dark theme were unreadable. Now they support the selected theme
* Fixed the TextFields background, also for the new implemente dTableView already implemented in transactions journal

### Known bugs
* Some translations are not well documented. Some messages are incomplete, wrong or missing. 
