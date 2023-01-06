type Props = {
    status : boolean
    changeStatus : () => void
}
export default function Switch(props : Props) {
    return (
        <div className={`switch ${props.status ? 'switchOpen' : ''}`} onClick={props.changeStatus}>
            <span></span>
            <span></span>
        </div>
    )
}