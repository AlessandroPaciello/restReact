import React, {Component, useState} from 'react';

class MenuUsers extends Component {

    constructor() {
        super();
        this.state = {users: [],
            user: null,
            modifyUser : false,
        }

    }

    componentDidMount() {
        fetch("api/users").then(response => response.json()).then(response => {
            this.setState({users : response})
            this.props.setUsers(this.state.users)
        })


    }

    render() {
        return (
            <React.Fragment>
                <ul>
                    {this.state.users.map(element => (
                        <ElementList element={element}/>
                    ))
                    }
                </ul>
            </React.Fragment>
        );
    }
}

function ElementList(props) {
    const [user, setUser] = useState(props.element)
    const [active, setActive] = useState(false)

    let prova = (e) => {
        setActive(true)
        fetch("api/users/" + e.target.id).then(response => response.json()).then(response => {})
    }

    return (
            <li id={user.id} key={user.id} onClick={prova}>
                <p>{user.id} {user.firstName} {user.lastName} {user.memo} {user.number} {user.date}</p>
                {
                    active && <p>elimina</p>
                }
            </li>
    )
}


export default MenuUsers;