# _Hair-Salon_

#### _Hair-Salon, 03-31-2017_

#### By _**Ben Schenkenberger**_

## Description
_Example text for the description of the project_


## Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|
| 1. A new stylist can be added | Georgio Ramirez | Georgio Ramirez |
| 2. New stylist name saved to profile | Georgio Ramirez | Georgio Ramirez |
| 3. New stylist's phone # saved to profile | Georgio Ramirez, 5032301512 | Georgio Ramirez, 5032301512 |
| 4. New stylist's email is saved to profile | Georgio Ramirez, 5032301512, georgio.ramirezstylist@gmail.com | Georgio Ramirez, 5032301512, georgio.ramirezstylist@gmail.com |
| 5. New stylist's hire date is saved to profile | Georgio Ramirez, 5032301512, georgio.ramirezstylist@gmail.com, 03-25-2017 | Georgio Ramirez, 5032301512, georgio.ramirezstylist@gmail.com, 03-25-2017 |
| 6. New stylist's experience is saved to profile | Georgio Ramirez, 5032301512, georgio.ramirezstylist@gmail.com, 03-25-2017, 12 years | Georgio Ramirez, 5032301512, georgio.ramirezstylist@gmail.com, 03-25-2017, 12 years |
| 7. A list of all stylists can be viewed | Georgio Ramirez, Valerie Ford | Georgio Ramirez, Valerie Ford |
| 8. A stylist's information can be updated/changed | change email to: georgio.ramirezstyles@gmail.com | georgio.ramirezstyles@gmail.com |
| 9. A stylist can be deleted | Delete: Georgio Ramirez | stylist name: "Georgio Ramirez" has been deleted from your list of active stylists |
| 10. A new client can be added to a stylist | Bob Fredrickson | Bob Fredrickson |
| 11. A new client's name is saved to profile | Bob Fredrickson | Bob Fredrickson |
| 12. A new client's stylist's name is saved to profile | Bob Fredrickson, Georgio Ramirez | Bob Fredrickson, Georgio Ramirez |
| 13. A new client's phone # is saved to profile | Bob Fredrickson, Georgio Ramirez, 9712758543 | Bob Fredrickson, Georgio Ramirez, 9712758543 |
| 14. A new client's email is saved to profile | Bob Fredrickson, Georgio Ramirez, 9712758543, bobfredrickson@gmail.com | Bob Fredrickson, Georgio Ramirez, 9712758543, bobfredrickson@gmail.com |
| 15. A new client's start date shows in their profile | Bob Fredrickson, Georgio Ramirez, 9712758543, bobfredrickson@gmail.com, 03-27-2017 | Bob Fredrickson, Georgio Ramirez, 9712758543, bobfredrickson@gmail.com, 03-27-2017 |
| 16. A new client's profile information can be updated/changed | change email to: bobfredrickson@nike.com | bobfredrickson@nike.com |
| 17. A client's profile can be deleted | Delete: Bob Fredrickson | client name: "Bob Fredrickson" has been deleted from your list of current clients |
| 18. A list of all of a stylists clients can be viewed | Georgio Ramirez: Bob Fredrickson, Anne Withers, Dan Fouts | Georgio Ramirez: Bob Fredrickson, Anne Withers, Dan Fouts |

## Setup/Installation Requirements

* _Clone the repository_
*_Create database on your local machine (See instructions below)_*
* _Run the command 'gradle run'_
* _Open browser and go to localhost:4567_

You must create the database on your local machine for this app to work correctly.

1. CREATE DATABASE hair_salon;

2. \c hair_salon;

3. CREATE TABLE stylists (id serial PRIMARY KEY, name varchar, phone varchar, email varchar, hire_date varchar, experience varchar);

4. CREATE TABLE clients (id serial PRIMARY KEY, name varchar, phone int, email varchar, created_at timestamp, stylist_id int);

5. CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

### License

Copyright (c) 2017 **_Ben Schenkenberger_**

This software is licensed under the MIT license.
