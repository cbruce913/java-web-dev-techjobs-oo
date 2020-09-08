package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;

    @Before
    public void createJobObjects() {
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        testJob3 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
        testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
}
