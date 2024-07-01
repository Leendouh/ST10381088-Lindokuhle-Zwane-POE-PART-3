package com.mycompany.LindokuhleAtWork;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class LoginFeatureTest {
    @BeforeEach
    public void setUp() {
        // Initialize or clear any necessary data before each test
        LoginFeature.developers.clear();
        LoginFeature.taskNames.clear();
        LoginFeature.taskIDs.clear();
        LoginFeature.taskDurations.clear();
        LoginFeature.taskStatuses.clear();

        // Populate sample data for testing
        LoginFeature.developers.add("Mike Smith");
        LoginFeature.developers.add("Edward Harrington");
        LoginFeature.developers.add("Samantha Paulson");
        LoginFeature.developers.add("Glenda Oberholzer");

        LoginFeature.taskNames.add("Create Login");
        LoginFeature.taskNames.add("Implement Dashboard");
        LoginFeature.taskNames.add("Bug Fixes");
        LoginFeature.taskNames.add("Create Reports");

        LoginFeature.taskIDs.add("CL:0:SMI");
        LoginFeature.taskIDs.add("ID:1:HAR");
        LoginFeature.taskIDs.add("BF:2:PAU");
        LoginFeature.taskIDs.add("CR:3:OBE");

        LoginFeature.taskDurations.add(8);
        LoginFeature.taskDurations.add(10);
        LoginFeature.taskDurations.add(6);
        LoginFeature.taskDurations.add(11);

        LoginFeature.taskStatuses.add("To Do");
        LoginFeature.taskStatuses.add("Doing");
        LoginFeature.taskStatuses.add("Done");
        LoginFeature.taskStatuses.add("To Do");
    }
    @Test
    public void testPopulateDevelopersArray() {
        // Test population of developers array
        LoginFeature.developers.clear();
        LoginFeature.developers.add("Mike Smith");
        LoginFeature.developers.add("Edward Harrington");
        LoginFeature.developers.add("Samantha Paulson");
        LoginFeature.developers.add("Glenda Oberholzer");

        assertEquals(4, LoginFeature.developers.size(), "Developer array should contain 4 entries");
        assertEquals("Mike Smith", LoginFeature.developers.get(0), "First developer should be Mike Smith");
        assertEquals("Edward Harrington", LoginFeature.developers.get(1), "Second developer should be Edward Harrington");
        assertEquals("Samantha Paulson", LoginFeature.developers.get(2), "Third developer should be Samantha Paulson");
        assertEquals("Glenda Oberholzer", LoginFeature.developers.get(3), "Fourth developer should be Glenda Oberholzer");
    }

    @Test
    public void testDisplayLongestTaskDeveloperAndDuration() {
        // Assuming correct implementation of displayLongestTaskDeveloperAndDuration()
        String result = LoginFeature.displayLongestTaskDeveloperAndDuration();

        // Test assertion
        assertEquals("Glenda Oberholzer, 11", result, "Expected developer and duration for longest task");
    }

    @Test
    public void testSearchTaskByName() {
        // Assuming correct implementation of searchTaskByName()
        String taskName = "Create Login";
        String expectedResult = "Mike Smith, Create Login, To Do";

        String result = LoginFeature.searchTaskByName(taskName);

        assertEquals(expectedResult, result, "Expected developer for task 'Create Login'");
    }

    @Test
    public void testSearchTasksByDeveloper() {
        /// Test searchTasksByDeveloper method
        String developer = "Samantha Paulson";
        String expectedResult = """
                                Task Name: Bug Fixes
                                Task ID: BF:2:PAU
                                Duration: 6 hours
                                Status: Done
                                
                                """;

        String result = LoginFeature.searchTasksByDeveloper(developer);

        assertEquals(expectedResult, result, "Expected tasks assigned to Samantha Paulson");
    }

    @Test
    public void testDeleteTaskFromArray() {
         // Test deleteTask method
        String taskToDelete = "Create Reports";
        String expectedResult = "Entry 'Create Reports' successfully deleted";

        String result = LoginFeature.deleteTask(taskToDelete);

        assertEquals(expectedResult, result, "Expected confirmation message for deleted task");
    
    }
}
