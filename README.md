# CricbuzzProject

Library used :

1 Navigation component
2 Gson Library
3 Data binding
4 LiveData
5 ViewBinding

Used MVVM architecture.

Brief work flow :

There are two modules in this project , "App" and "LocalDatabase" . "App" is the default module and a separate
module is being created to store the data inside the Restaurants models class and
even if we have to store the data locally such as using Room or sharedpreference , we could have done all this in this module only.

Navigation component is being used to achieve single activity app . Here only one screen is there so we don't need to
create any fragment but only to demonstrate that how I do in live projects where more than one screen is there , i have used navigation component.

First we are parsing the Json file using the GSON library and then inflating it into the model classes and from there
we are fetching the data and displaying it using recyclerview and then using the search , filtered result gets displayed on the UI.

Search will start filtering the result only if you type more than 2 letters , logic used for search is mentioned below :

Inserted the Menu json inside the Restaurant json using the restaurant id  and then run the loop for each
restaurant i.e first comparing the searched string with the restaurant name and if string matched successfully with the
restaurant name then we donn't need to check for Menu items and cuisine that's why we don't proceed further and then will
start checking for the next restaurnat in the loop ,  if string does not match with restaurant name then we will check
for cuisine and if we get the result successfully we don't need to check for Items
and if we do get result with cuisine then we proceed to the Items.


Other Possibilities :

Since search can be implemented using different logics but using the data analysis i.e if we analyse
data we could get many ideas for instance how frequently some data is used , what user searches most of the time so considering
all these factor we can optimize the search .

Over here what we else can do is we can separate out the Items names such as "Biryani" , "Dal" , "Rice" , "Appeteasers" etc
from different Restaurants and store it one table , similarly we can do this for the cuisine and Restaurant as well
and then adding all these three different list and creating a single list , keeping in mind to remove the repeated Strings.
The strings in list will be the "Key" and the Restaurant id will be there corresponding values.

For instance suppose we searched "Bir" so it might be possible that an item name such as "Birayani" and then a Restaurant name "BirRehmani"
will be there in the list , we will get the Restaurant ids as the value from the key "Biryani" and "BirRehmani" ,
so it might be possible that Restaurant ids could repeat , so we will filter the repeated ids to avoid repetition
and then we will left with a list of restaurant id with unique ids.

But if all the restaurant will be having all items different from each other then this logic won't be efficient because a large
list of string will be created and everytime we have to traverse through all list. And as it was not mentioned in the question that
if each restaurant might have some items same or not , so i didn't choose this way.
