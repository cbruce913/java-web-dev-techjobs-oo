package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    static Job testJob1;
    static Job testJob2;
    static Job testJob3;
    static Job testJob4;
    static Job testJob5;
    String jobAsString = testJob1.toString();

    @BeforeClass
    public static void createJobObjects() {
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        testJob3 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
        testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob5 = new Job();
    }

    @Test
    public void emptyTest() {
        assertEquals(10, 10, .001);
    }

    @Test
    public void testSettingJobId() {
        assertTrue(testJob1.getId() != testJob2.getId());
        assertTrue(testJob2.getId() - testJob1.getId() == 1);
    }

    @Test
    public void constructorSetsId() {
        assertTrue(testJob3.getId() == 3);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJob4 instanceof Job);
        assertTrue(testJob4.getName() == "Product tester");
        assertTrue(testJob4.getEmployer() instanceof Employer);
        assertEquals(testJob4.getEmployer().getValue(), "ACME");
        assertTrue(testJob4.getLocation() instanceof Location);
        assertEquals(testJob4.getLocation().getValue(), "Desert");
        assertTrue(testJob4.getPositionType() instanceof PositionType);
        assertEquals(testJob4.getPositionType().getValue(), "Quality control");
        assertTrue(testJob4.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob4.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob1.getId() == testJob4.getId());
    }

    @Test
    public void blankFirstAndLastLineTest() {
        assertEquals(jobAsString.indexOf("\n"), 0);
        assertEquals(jobAsString.lastIndexOf("\n"), jobAsString.length()-1);
    }

    @Test
    public void fieldLabelTest() {
        assertTrue(jobAsString.contains("ID"));
        assertTrue(jobAsString.contains("Name"));
        assertTrue(jobAsString.contains("Employer"));
        assertTrue(jobAsString.contains("Location"));
        assertTrue(jobAsString.contains("Position Type"));
        assertTrue(jobAsString.contains("Core Competency"));
    }

    @Test
    public void fieldNewLineTest() {
        assertTrue(jobAsString.contains("\nID"));
        assertTrue(jobAsString.contains("\nName"));
        assertTrue(jobAsString.contains("\nEmployer"));
        assertTrue(jobAsString.contains("\nLocation"));
        assertTrue(jobAsString.contains("\nPosition Type"));
        assertTrue(jobAsString.contains("\nCore Competency"));
    }

    @Test
    public void emptyFieldTest() {
        assertTrue(testJob5.toString().contains("Data not available"));
    }

    @Test
    public void jobExistenceTestBONUS() {
        assertEquals("OOPS! This job does not seem to exist.", testJob5.toString());
    }
}
