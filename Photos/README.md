## Getting Started

This is the Photos Application. I have written some notes about the application to add more context about certain features. 

## Folder Structure

The workspace contains 3 folders but `src` contains everything within the appication:

- `main`: the main method
- `controller`: call the controller files 
- `scene`: all the fxml files 
- `stock`: stock images
- `classes`: classes for User, Photo and Album

## TableView NOT Loading Initially

There is some issue with the tableview not loading, when the view is initially loaded. But, when you select a different album from the albumList of the mainPage and go back to it, it loads up.

## All Photos Album

Whenever a new user is created, an album called All Photos is also created. It acts just like any album, except when the user uploads a photo, that photo gets added to the All Photos album (quite similar to most photos apps like Google Photos or Apple Photos). So the user can, technically, not create any album and just upload their photos to the application. 

Although, they can still create a new album and then add photos to it. (Which is basically adding instances of the photo from the All Photos album). This fulfills the copy photos from one album to another criteria.

## Stock Images

I was kind off confused with how stock images were supposed to be used. Because the assignment page said that we need to store stock photos under a user named stock, but also under an album called stock. So, I wrote the code so that every user that's created has stock images under the album called stock. 

So, you can just create a new Account using the signUp features, containing username: stock and password: stock, for the stock user criteria.

## Image Preview

The user has to double stick on one of the images from the TableView to get the Image Preview feature working. The Image Preview also acts as an Image Edit Feature where the user can change the Photo's Caption or Tags and click save. 

## Search Feature

The search feature searches through the currently selected album. It looks for the Photo's date, caption and tags. So, it filters the tableview based on those properties. 