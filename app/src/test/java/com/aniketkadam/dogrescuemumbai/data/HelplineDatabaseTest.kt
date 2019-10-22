package com.aniketkadam.dogrescuemumbai.data

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Chetan on 2019-10-19.
 */
@RunWith(AndroidJUnit4::class)
class HelplineDatabaseTest {

    lateinit var helpLineDatabase: HelplineDatabase
    lateinit var helpLineDao: AnimalHelplLineDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        helpLineDatabase = Room.inMemoryDatabaseBuilder(context, HelplineDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        helpLineDao = helpLineDatabase.helpLineDao()
    }

    @Test
    fun testDatabase() {

        val location = Location(
            latitude = 34.44f,
            longitude = 23.4f
        )

        val helpLine = AnimalHelpLine(
            id = 1,
            location = location,
            address = "Ghatkopar west",
            phone = listOf("022 12345678", "022 11223344"),
            email = "rescue@animalhelp.com"
        )

        helpLineDao.insert(helpLine)

        val savedHelpLine = helpLineDao.getById(1)

        Assert.assertNotNull(savedHelpLine)

    }

    @After
    fun closeDb() = helpLineDatabase.close()
}