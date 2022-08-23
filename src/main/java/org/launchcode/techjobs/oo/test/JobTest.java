package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.swing.text.Position;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertNotEquals(firstJob, secondJob);

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testFields.getName() instanceof String);
        assertEquals(testFields.getName(), "Product tester");
        assertTrue(testFields.getEmployer() instanceof Employer);
        assertEquals(testFields.getEmployer().toString(), "ACME");
        assertTrue(testFields.getLocation() instanceof Location);
        assertEquals(testFields.getLocation().getValue(), "Desert");
        assertTrue(testFields.getPositionType() instanceof PositionType);
        assertEquals(testFields.getPositionType().getValue(), "Quality control");
        assertTrue(testFields.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testFields.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job testJobOne = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobTwo = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJobOne.equals(testJobTwo));
}

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJobOne = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String str = testJobOne.toString();
        assertEquals('\n', str.charAt(0));
        assertEquals('\n', str.charAt(str.length() - 1));
    }
//should test that each label is correctly aligned with data within label.
    //assertEquals?
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJobOne = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toStringTest = "\nID: " + testJobOne.getId() +
                              "\nName: " + testJobOne.getName() +
                              "\nEmployer: " + testJobOne.getEmployer() +
                              "\nLocation: " + testJobOne.getLocation() +
                              "\nPosition Type: " + testJobOne.getPositionType() +
                              "\nCore Competency: " + testJobOne.getCoreCompetency() +
                              "\n";
        assertEquals(toStringTest, testJobOne.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job testJobOne = new Job ("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String toStringTest = "\nID: " + testJobOne.getId() +
                              "\nName: " + "Data not available" +
                              "\nEmployer: " + "Data not available" +
                              "\nLocation: " + "Data not available" +
                              "\nPosition Type: " + "Data not available" +
                              "\nCore Competency: " + "Data not available" +
                              "\n";
        assertEquals(testJobOne.toString(), toStringTest);
    }
}
