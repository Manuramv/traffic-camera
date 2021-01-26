# Traffic Camera
This app will show the list of Traffic Cameras in the Singapore and by clicking on the map marker you can see the latest photo captured by the camera.


![Traffic Camera App](https://user-images.githubusercontent.com/31012185/105796826-a4550580-5fca-11eb-85f1-4d462f817acd.png)
*Fig. 1: Demonstrating App*

![Traffic Camera App](https://user-images.githubusercontent.com/31012185/105797229-d2d2e080-5fca-11eb-9cb6-dd409945368a.png)
*Fig. 1: Demonstrating App*

![Traffic Camera App](https://user-images.githubusercontent.com/31012185/105797432-eda55500-5fca-11eb-9c6c-9bfcf78544b5.png)
*Fig. 1: Demonstrating App*

![Traffic Camera App](https://user-images.githubusercontent.com/31012185/105797572-31985a00-5fcb-11eb-9915-9205242d1f3d.gif)
*Fig. 1: Showing the Traffic cameras and Markr click*


![Traffic Camera App](https://user-images.githubusercontent.com/31012185/105797828-bbe0be00-5fcb-11eb-9093-132392c26539.gif)
*Fig. 1: Error Case*


# Built With
  Kotlin

# Architectural Pattern
- Used MVVM as the code can be easily reused and binding makes UI updates easier to handle. 
- This architecture makes the code more modular so maintainability of code in future will be more easy
- `LiveData` - **LiveData** to update the UI automatically when the data updates. We Used LiveData extensively to communicate between view and viewmodel. Whenever the API call is success it will update the UI automatically according to our design.



#  Data Binding & 2 Way data Binding
- I've followed the data binding approach to bind the views with classes and view models,so that I can perform the UI actions with less code and directly from viewmodel.We have extensively used data binding in this application wherever it's possible. 
- My Activity class and Spinner Adapter looks very clean.
- `Binding Adapters` used for the `Imageview` and `Textview`
    
# Other Important Libraries Used:
- `Retrofit` - For networking calls
- `Glide` - To Render the Image.
 # Packages in the App:
    - Binders- Binding adapters (ImageBinder, TextBinder)
    - Data - Retrofit API related class and repository classes under sub repositroy project.
    - Model - Model classes and kotlin data classes
    - UI - Views and Viewmodels
    - Utils - Date utils, Constants and Alert Classes.
    
# Supported version
Android 21(5.0)

# Further Enhancements(Improvements that could be done to this App)
- We can add test cases.


