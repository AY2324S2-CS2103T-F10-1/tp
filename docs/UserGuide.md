---
layout: page
title: User Guide
nav_order : 2
---
# Nursing Address Book (NAB)
Nursing Address Book (NAB) is a desktop application tailored for ward nurses, optimizing patient contact management via a Command Line Interface (CLI) while incorporating a Graphical User Interface (GUI) for ease of use.
Designed for efficiency, NAB enables quick access to patient records, streamlined contact management, and simplified logging of care details, proving to be a valuable tool for fast typists and those who prefer the precision of CLI operations.

## Table of Contents
* [Quick Start](#quick-start)
* [Features](#features)
  * [Adding a Patient](#adding-a-patient-add)
  * [Viewing Patients](#listing-all-patients--list)
  * [Editing a Patient](#editing-a-patient--edit)
  * [Finding a Patient](#locating-patients-by-name-find)
  * [Deleting a Patient](#deleting-a-patient--delete)
  * [Viewing Help](#viewing-help--help)
  * [Clearing all Entries](#clearing-all-entries--clear)
  * [Exiting the Application](#exiting-the-program--exit)
* [FAQ](#faq)
* [Command Summary](#command-summary)
* [Troubleshooting](#troubleshooting)

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `nab.jar` from [here](https://github.com/AY2324S2-CS2103T-F10-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

4. Open a command terminal, For Windows users, search for `cmd` in the Start menu and run it as an administrator if necessary. Use the `cd` command to navigate to the folder where you placed the jar file. Run the application by executing `java -jar nab.jar`.<br>
   Shortly, a GUI resembling the following should display, including some sample input to get you started:<br>
   ![Ui](images/Ui.png)
   <br>
   _Note for Windows Users: Ensure you have the necessary permissions to execute commands. Running the command prompt as an administrator may be required._
5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all patients.

   * `add n\John Doe ic\T1234567P dob\01/01/2000 w\A1 ad\25/03/2024` : Adds a patient named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd patient shown in the current list.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n\NAME`, `NAME` is a parameter which can be used as `add n\John Doe`.

* Items in square brackets are optional.<br>
  e.g `n\NAME [t\TAG]` can be used as `n\John Doe t\FallRisk` or as `n\John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t\TAG]…​` can be used as ` ` (i.e. 0 times), `t\Diabetes`, `t\Diabetes t\HearingImpaired` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n\NAME ic\IC_NUMBER`, `ic\IC_NUMBER n\NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `exit`) will be ignored.<br>
  e.g. if the command specifies `exit 123`, it will be interpreted as `exit`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Adding a patient: `add`

Adds a new patient's information to the address book.

Format: `add n\NAME ic\IC_NUMBER dob\DATE_OF_BIRTH ad\ADMISSION_DATE w\WARD [r\REMARK] [t\TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

* NAME: The full name of the patient. Only alphabetical characters are accepted. Each word should be split with a whitespace.
* IC_NUMBER: The Identification Number of the patient. It must start with a capital letter, followed by a 7-digit number and ends with a capital letter.
* DATE_OF_BIRTH: The patient's date of birth in DD/MM/YYYY format. Dates must be in the past.
* ADMISSION_DATE: The date the patient was admitted to the ward, also in DD/MM/YYYY format. This date should not be later than the current date.
* WARD: The ward where the patient is located. This should contain alphanumeric characters only, with no spaces.
* REMARK: Optional remarks about the patient.
* TAG: Optional tags to categorize the patient by health condition or other descriptors. Tags should be alphanumeric and can be used multiple times.

* Example command:

`add n\John Doe ic\T1234567P dob\21/03/2000 ad\02/02/2022 w\A1 t\FallRisk r\Requires assistance feeding. t\Diabetes`

```
The patient, John Doe, is added! Here are his details:

John Doe
IC: T1234567P
Date of Birth: 21 Mar 2000
Admission Date: 2 Feb 2022
Ward: A1
Remarks: Requires assistance feeding.
Tags: FallRisk, Diabetes

You now have 1 patient(s) in your address book.
```

### Listing all patients : `list`

Displays a list of all registered patients.

Format: `list`, `list [w\WARD] [t\TAG]...`

* WARD: Must only list at most 1 ward.

Example command:

`list`
```
Here are the details of the 2 patients in your contact book:

1. John Doe
2. Jane Doe
```

Example command:

`list w\B4 t\SeverAllergies`
```
Listed all persons with:
Tags: FallRisk
Ward: B4

Jane Doe
IC: I2103210P
Date of Birth: 12 Nov 1999
Admission Date: 3 Mar 2024
Ward: B4
Tags: SevereAllergies
```

### Editing a patient : `edit`

Edits an existing patient's details in the address book.

Format: `edit INDEX [n\NAME] [ic\IC_NUMBER] [dob\DATE_OF_BIRTH] [ad\ADMISSION_DATE] [w\WARD] [r\REMARK] [t\TAG]…​`

* Edits the patient details at the specified `INDEX`. The index refers to the index number shown in the displayed list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the patient will be removed i.e adding of tags is not cumulative.
* You can remove all the patient’s tags by typing `t\ ` without
    specifying any tags after it.

Example command:

`edit 1 ic\T0123456P t\ r\`

_Edits the IC_NUMBER, TAGS and REMARKS of the 1st person to be `T0123456P` for IC_NUMBER and empty for both tags and remarks._

**Before**:
```
John Doe
IC: T1234567P
Date of Birth: 21 Mar 2000
Admission Date: 2 Feb 2022
Ward: A1
Remarks: Requires assistance feeding.
Tags: FallRisk, Diabetes
```
**After**:
```
Edited details of patient 1 in your contact book as follows:

John Doe
IC: T0123456P
Date of Birth: 21 Mar 2000
Admission Date: 2 Feb 2022
Ward: A1
Remarks:
Tags:
```

### Locating patients either by name or by IC: `find`

You can find patients whose names or IC contain any of the given keywords.

Format: `find [n\NAME] [ic\IC_NUMBER]`

* Exactly one of the optional fields must be provided
* The search is case-insensitive. e.g. `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`
* Only full IC will be matched e.g. `a1234567b` will not match `123`

Examples:
* `find n\John` returns `john` and `John Doe`
* `find n\alex david` returns `Alex Yeoh` and `David Li`
* `find ic\a1234567b` returns `A1234567B`<br>

### Deleting a patient : `delete`

Deletes the specified patient from the address book.

Format: `delete INDEX`

* Deletes the patient records at the specified `INDEX`.
* The index refers to the index number shown in the displayed list.
* The index **must be a positive integer** 1, 2, 3, …​

Example command:

`delete 2` deletes the 2nd person in the address book.
```
Deleted Person: Jane Doe
IC: A1234567B
DOB: 02/02/2000
Ward: A1
<<<<<<< HEAD
Remarks:
=======
Admitted: 02/02/2020
Remarks: likes to go to the park
>>>>>>> 078193eafdd0590706eff5a64ce34362144dbd50
Tags: SevereAllergies
```
### Viewing help : `help`

Shows a message explaining the available commands and their usage.

Format: `help`

Output:

```
Here are the list of available commands:

Add: add n\NAME ic\IC_NUMBER dob\DATE_OF_BIRTH ad\ADMISSION_DATE w\WARD [t\TAG]...
   Example: add n\John Doe ic\T1234567P dob\01/01/2000 ad\25/03/2024 w\A1 t\Diabetes t\FallRisk

Clear: clear
   Clears all entries from the address book.

Delete: delete INDEX
   Example: delete 3

Edit: edit INDEX [n\NAME] [ic\IC_NUMBER] [dob\DATE_OF_BIRTH] [ad\ADMISSION_DATE] [w\WARD] [t\TAG]...  
   Example: edit 1 ic\T0123456P t\

Find: find KEYWORD [MORE_KEYWORDS]
   Example: find John

List: list
   Lists all patients.

Exit: exit
   Exits the application.

For more detailed information on each command, please refer to the User Guide.
```


### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

### Viewing help : `help`

Shows a message explaining commands available.

_coming in v1.3 ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n\NAME ic\IC_NUMBER dob\DATE_OF_BIRTH ad\ADMISSION_DATE w\WARD [t\TAG]…​` <br> e.g., `add n\James Ho ic\A1234567B dob\21/03/1999 ad\21/01/2023 w\A1 t\HearingImpaired`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n\NAME] [ic\IC_NUMBER] [dob\DATE_OF_BIRTH] [ad\ADMISSION_DATE] [w\WARD] [t\TAG]…​`<br> e.g.,`edit 2 n\James Lee w\A2`
**Find** | `find n\KEYWORD [MORE_KEYWORDS]`, `find ic\KEYWORD`<br> e.g., `find n\James Jake`, `find ic\a1234567b`
**List** | `list`
**Help** | `help`

--------------------------------------------------------------------------------------------------------------------

## Troubleshooting

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
