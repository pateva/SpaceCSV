# SpaceCSV
This program reads a standart CSV file with specified weather conditions and returns a new CSV file with the most appropriate space shuttle launch date and an aggregated data for every parameter. The newly generated file is then send per mail to a receiver.

Structure of the incoming CSV fail (row arrangement is not strict):
![image](https://github.com/pateva/SpaceCSV/assets/83903221/66dae9be-b1d7-412f-a5fb-fb43a5fcb24a)

Conditions to calculate the most appropriate date:
- Temperature between 2 and 31 degrees Celsius;
- Wind speed no more than 10m/s (the lower the better);
- Humidity less than 60% (the lower the better);
- No precipitation;
- No lightings;
- No cumulus or nimbus clouds.

Output file:

![image](https://github.com/pateva/SpaceCSV/assets/83903221/c8e49b7e-ecb6-4f18-b44e-6087acc732f9)

*It is intentional that there are no values for Lightning and Clouds



