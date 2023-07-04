## Design a calendar Application (similar on lines with Google's Calendar)

----------------------------------------

**_It should support the following functionalities:_**

1. Ability to create, update, delete an Event 
   2. An event would typically consist of {start, end, location, Owner, user-list, title}. 
   3. Events can either be like meetings(with a dedicated location and appropriate guest-list) or as well be like holidays, birthdays, reminders etc. 
   4. An event once created, can be either accepted or rejected by the constituent users - if neither it should be in neutral state.
6. Get Calendar for a user Ui 
7. Get Event details. 
8. For a given set of users ```[U1, U2,....Un]``` identity a common free slot of time.

### Expectations

1. Code should a demo able, either by using a main driver program or test cases. 
2. Create the sample data yourself. you can put it into a file, test case or main driver program itself. 
3. Avoid writing monolithic code. 
4. Code should be readable, modular, testable, extensible with proper naming conventions. It should be easy to add/remove functionality without rewriting entire codebase. 
5. Code should handle edge cases properly and fail gracefully. 
6. Don't use any external data store, all the data should be loaded in application itself. 
7. Don't spend lot of the time in parsing the input.

### Guidelines
Input can be read from file or can be hard coded/used. 
Use 90 mins to complete the whole exercise