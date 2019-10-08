package io.github.fatimazza.unittestingcuboid

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyHeight = 2.0
    private val dummyLength = 3.0
    private val dummyWidth = 4.0

    private val dummyCircumference = 96.0
    private val dummySurfaceArea = 52.0
    private val dummyVolume = 24.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun getCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)

        val circumference = mainViewModel.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun getSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)

        val surfaceArea = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun getVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight)

        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }
}
