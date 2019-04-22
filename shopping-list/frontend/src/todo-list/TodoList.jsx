import React, {Component} from "react";
import TodoItem from "./TodoItem";
import NewItem from "./NewItem";
import Calls from "../calls";
import Loading from "./Loading";

export default class TodoList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [],
      loadingState: "INIT"
    };
  }

  async componentDidMount() {
    this.setState({ loadingState: "LOADING" });
    try {
      let result = await Calls.getShoppingList();
      this.setState({ items: result, loadingState: "DONE" });
    } catch (error) {
      this.setState({ error:error, loadingState: "ERROR" });
    }
  }

  renderItems = () => {
    return this.state.items.map(this.renderItem);
  };

  renderItem = (item, index) => {
    return (
      <TodoItem
        key={item.id}
        item={item}
        onDelete={() => {
          this.removeItem(item, index);
        }}
        onChange={newItem => {
          this.changeItem(item, index, newItem);
        }}
      />
    );
  };

  removeItem = async (item, index) => {
    let items = [...this.state.items];
    await Calls.deleteShoppingItem({ id: item.id });
    items.splice(index, 1);
    this.setState({ items: items });
  };

  changeItem = async (item, index, newItem) => {
    let items = [...this.state.items];

    let serverItem = await Calls.updateShoppingItem(newItem);

    items[index] = serverItem;
    this.setState({ items: items });
  };

  addItem = async text => {
    let items = [...this.state.items];

    let serverItem = await Calls.createShoppingItem({
      content: text,
      state: "NEW",
      count: 1,
      // createdAt: new Date().toUTCString()
      createdAt: new Date()
    });
    items.push(serverItem);
    this.setState({ items: items });
  };

  renderChilds = () => {
    switch (this.state.loadingState) {
      case "LOADING":
        return <Loading />;
      case "DONE":
        return (
          <React.Fragment>
            {this.renderItems()}
            <NewItem onAdd={this.addItem} />
          </React.Fragment>
        );
      case "ERROR":
        return <div>Error: {""+this.state.error}</div>;
      default:
        return <div>Error</div>;
    }
  };

  render() {
    return <div className="todo-list">{this.renderChilds()}</div>;
  }
}
