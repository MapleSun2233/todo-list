import Position from "../../type/Position";

type Props = {
    position : Position
    callback : () => void
}
export default function ContextMenu(props : Props) {
    const style = {
        left : props.position.x + 10 + "px",
        top : props.position.y + 10 +"px"
    }

    return (
        <div className="contextMenu" style={style}>
            <div onClick={props.callback}>删除</div>
        </div>
    )
}