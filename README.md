# Kotlin Boilerplate

This code is a boilerplate code using kotlin langauge with various libraries like Dagger 2.11, Rxjava, Retrofit. You can use this format to start your project from scratch.

## Getting Started

### Splash Screen

- Splash screen is basically added using drawable xml without any layout.


### Session Manager

- Check session manager class for all shared prefrence code

### Data Binding

- Check login Activity, Login ViewModel & Login XML for data binding.
- For binder for data binding check utils/binder package

### Api call using Retrofit

- Check loginactivity for api call
- Api call is only using get method for now 

### Home Fragment Screen

- Home Fragment Screen is an example to add a fragment in mvvm with dagger

### List Fragment Screen

- List Fragment Screen is an example to add a recycler view using data binding. For image load binder is added with glide.

### Progress Bar

- In each xml progress bar layout is added. Which is managed on the basis of a variable using data binding.

### Image loading from url

- For image loading from url glide library is used, you can check the ImageViewBinder class in utils/binder package for same. Image loading is done through xml using data binding, for xml check the row_user xml .

       <ImageView
        android:id="@+id/restaurantImageView"
        loadImage="@{user.image}"
        place="@{@drawable/ic_launcher_foreground}"
        android:layout_width="130dp"
        android:layout_height="100dp"
        android:scaleType="centerCrop" />





