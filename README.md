# My Travel Diary 

## *A tracker for all your travel needs*

**Travel Diaries** displays your own personalized record of a title of your name 
and the flight you are currently taking. With **Travel Diaries**, you are able to 
add flights and remove flights from your travel diary by being able to see a list
of flights that are flying. Each flight displays the destination it is flying to, 
the price, the duration of the flight, and the number of vacant seats currently 
left on the flight. You are able to select the flight from the list and add
it to **Travel Diaries**. With that, the program removes the vacant seat
from the flight to reduce over-booking. If you change your mind about the booked
flight, no problem! Simply, just remove the flight from your travel diary and 
the program would add back a vacant seat to become available. This app would attract 
users from all around the world. This project interests me from one of my current 
goals of wanting to travel around the world and explore. Having an application 
like this would make travellers lives much easier with having all you flights 
in place and also keep a nice digital diary for memories of all the flights 
you have already taken. 
Introducing *Travel Diaries*!

In the context of a "Travel Diary" tracker application:
- As a user, I want to be able to view my current flights
- As a user, I want to be able to add a flight that includes flight number, 
airline, and destination to my travel diary 
- As a user, I want to be able to remove a flight from my travel diary 
- As a user, I want to be able to select a flight and see all the
information needed
- As a user, I want to be able to save flights to my travel diary to file
- As a user, I want to be able to be able to load flights from my travel diary from file

# Instructions for Grader

- You can generate the first required event by clicking add flight and adding a flight 
with a flight number, airline name, and destination name
- You can generate the second required event by clicking remove and selecting 
one of the flights in the travel diary
- You can locate my visual component by running the class TravelDiaryGUI
- You can save the state of my application by clicking the save button which 
you cau view in MyTravelDiary file that is saved
- You can reload the state of my application by clicking load in the beginning 
of the GUI 

Phase 4: Task 2

Loaded My Travel Diary from ./data/MyTravelDiary.json
F1	FLAIR				Calgary
F2	FLAIR				Edmonton
F3	FLAIR				Kelowna
AC1	AIR CANADA				Toronto
AC2	AIR CANADA				Toronto
AC3	AIR CANADA				Winnipeg
W1	WEST JET				Toronto
W2	WEST JET				Saskatchewan
S1	SWOOP				Nunavut
S2	SWOOP				Montreal
Thu Aug 11 14:29:17 PDT 2022
Calgary added in Travel Diary
Thu Aug 11 14:29:17 PDT 2022
Edmonton added in Travel Diary
Thu Aug 11 14:29:17 PDT 2022
Kelowna added in Travel Diary
Thu Aug 11 14:29:17 PDT 2022
Toronto added in Travel Diary
Thu Aug 11 14:29:17 PDT 2022
Winnipeg added in Travel Diary
Thu Aug 11 14:29:17 PDT 2022
Saskatchewan added in Travel Diary
Thu Aug 11 14:29:17 PDT 2022
Nunavut added in Travel Diary
Thu Aug 11 14:29:17 PDT 2022
Montreal added in Travel Diary
Thu Aug 11 14:29:49 PDT 2022
Hawaii added in Travel Diary
Thu Aug 11 14:30:56 PDT 2022
California added in Travel Diary
Thu Aug 11 14:31:01 PDT 2022
Removed flight from Travel Diary
Thu Aug 11 14:31:20 PDT 2022
Removed flight from Travel Diary

Phase 4: Task 3

- I would simplify TravelDiaryGUI and TravelDiaryUI since both of the classes have a relationship
  with JsonReader, JsonWriter, and TravelDiary. I would add one of the these two
  functions and combine into one class so the code is more coherent and by merging these 
two would reduce code redundancy.

