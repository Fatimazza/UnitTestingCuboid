package io.github.fatimazza.unittestingcuboid

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getCircumference(): Double = cuboidModel.getCircumference()
    fun getSurfaceArea(): Double = cuboidModel.getSurfaceArea()
    fun getVolume(): Double = cuboidModel.getVolume()
    fun save (length: Double, width: Double, height: Double) {
        cuboidModel.save(length, width, height)
    }
}
