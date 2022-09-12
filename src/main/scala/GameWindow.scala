// all the imports we're going to need in the entire app
// (auto-import helps a lot, but adding them here in case of confusion)

import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import scalafx.scene.control._
import scalafx.geometry.{Insets,Pos}
import scalafx.scene.effect.{BlurType, DropShadow}
import scalafx.scene.layout.VBox
import scalafx.scene.paint._
import scalafx.scene.text.{Font, Text}

object GameWindow extends JFXApp3 {

  override def start(): Unit = {
    val gameScene = new Scene{
      fill = Color.LightBlue
    }
    val menuScene = new Scene {
      fill = Color.rgb(38, 38, 38)
      content = new VBox {
        alignment = Pos.Center
        padding = Insets(50, 80, 50, 80)
        children = Seq(
          new Text {
            text = "Bloxorz"
            style = "-fx-font: normal bold 75pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Red, DarkRed))
          },
          new Text {
            text = "FX"
            style = "-fx-font: italic bold 75pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(White, DarkGray)
            )
            effect = new DropShadow {
              color = DarkGray
              radius = 15
              spread = 0.25
            }
          },
          new Button {
            text = "Play"
            padding = Insets(20, 80, 20, 80)
            margin = Insets(20, 80, 20, 80)
            onAction = () => {
              stage.scene = gameScene
            }
          },
          new Button {
            text = "Exit"
            padding = Insets(20, 80, 20, 80)
            margin = Insets(20, 80, 20, 80)
            effect = new DropShadow( BlurType.OnePassBox , Color.White , 0, 0.0 , 0 , 1 )
            onAction = () => {
              stage.close()
            }
          }
        )
      }
    }
    stage = new JFXApp3.PrimaryStage {
      title = "Bloxorz-game"
      width = 800
      height = 800
      resizable = false
      scene = menuScene
    }
  }
}