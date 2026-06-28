package example

import org.scalajs.dom
import THREE.*

@main
def helloWorld(): Unit = {
  val canvas = dom.document.createElement("canvas").asInstanceOf[dom.HTMLCanvasElement]
  canvas.id = "webgl"
  canvas.style.width = "100%"
  canvas.style.height = "100%"
  canvas.style.display = "block"
  dom.document.body.appendChild(canvas)

  val renderer = WebGLRenderer(canvas)

  renderer.setSize(dom.window.innerWidth.toDouble, dom.window.innerHeight.toDouble)

  val scene = Scene()

  val camera = PerspectiveCamera(75, dom.window.innerWidth.toDouble / dom.window.innerHeight.toDouble, 0.1, 1000)
  camera.position.z = 4

  val geometry = BoxGeometry()
  val material = MeshBasicMaterial(color = 0x44aa88)
  val cube = Mesh(geometry, material)
  scene.add(cube)

  def animate: () => Unit = () => {

    cube.rotation.x += 0.01
    cube.rotation.y += 0.01
    renderer.render(scene, camera)

    renderer.setAnimationLoop(animate)
  }

  animate()
}

import org.scalajs.dom


